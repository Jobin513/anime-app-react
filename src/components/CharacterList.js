import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import '../CharacterList.css';
import styled from 'styled-components';

function CharacterList({ characterName }) {
  const [characters, setCharacters] = useState([]);
  const CharacterCard = styled.div`
  text-align: center;
  margin: 0 10px 20px;
  display: inline-block;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  background-color: lightyellow;
  p {
    margin: 0;
    font-weight: bold;
  }

  a {
    text-decoration: none;
    color: #007BFF;
    transition: color 0.2s ease-in-out;
    
    &:hover {
      color: #0056b3;
    }
  }

  img {
    width: 100px;
    height: 150px;
    display: block;
    margin: 10px auto;
    cursor: pointer;
    
  }
`;


  useEffect(() => {
    if (characterName) {
      const apiUrl = `http://localhost:8080/character/${characterName}`;

      fetch(apiUrl)
        .then((response) => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json();
        })
        .then((data) => {
          if (data && data.data && Array.isArray(data.data)) {
            setCharacters(data.data); 
          } else {
            console.error('Invalid API response:', data);
          }
        })
        .catch((error) => {
          console.error('There was a problem with the fetch operation:', error);
        });
    }
  }, [characterName]);

  return (
    <div style={{
      textAlign: 'center',
      border: '2px solid #ccc', 
      padding: '20px',           
      borderRadius: '10px',     
      boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',  
      backgroundColor: 'rgba(240, 240, 240, 0.8)'
    }}>
      <h2 style={{ textAlign: 'center' }}>Choose Your Character</h2>
      <h4 style={{ textAlign: 'center' }}>
        <Link to="/">Return to Home</Link>
      </h4>
      <div style={{ textAlign: 'center' }}>
        {characters.map((character) => (
          <CharacterCard key={character.mal_id}>
            <p>
              <Link to={`/voiceactors/${character.mal_id}`}>
                {character.name}
              </Link>
            </p>
            <a href={character.url} target="_blank" rel="noopener noreferrer">
              <img src={character.images.jpg.image_url} alt={character.name} />
            </a>
          </CharacterCard>
        ))}
      </div>
    </div>
  );
}

export default CharacterList;

