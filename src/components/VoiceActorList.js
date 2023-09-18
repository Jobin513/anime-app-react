import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { useParams } from 'react-router-dom';

function VoiceActorList() {
  const { characterID } = useParams();
  const [voiceActors, setVoiceActors] = useState([]);

  const VoiceActorCard = styled.div`
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
    const apiUrl = `http://localhost:8080/charactervoices/${characterID}`;

    fetch(apiUrl)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then((data) => {
        if (Array.isArray(data)) {
          setVoiceActors(data); 
        } else {
          console.error('Invalid API response:', data);
        }
      })
      .catch((error) => {
        console.error('There was a problem with the fetch operation:', error);
      });
  }, [characterID]);

  const reverseName = (name) => {
    const nameParts = name.split(','); 
    if (nameParts.length === 2) {
      const [lastName, firstName] = nameParts;
      return `${firstName.trim()} ${lastName.trim()}`; 
    }
    return name; 
  };

  return (
    <div style={{
      textAlign: 'center',
      border: '2px solid #ccc', 
      padding: '20px',           
      borderRadius: '10px',     
      boxShadow: '0 0 10px rgba(0, 0, 0, 0.1)',  
      backgroundColor: 'rgba(240, 240, 240, 0.8)'
    }}>
      <h2 style={{ textAlign: 'center' }}>Choose Your Language</h2>
      <h4 style={{ textAlign: 'center' }}>
        <Link to="/">Return to Home</Link>
      </h4>
      <div style={{ textAlign: 'center' }}>
        {voiceActors.map((voiceActor) => (
          <VoiceActorCard key={voiceActor.person.mal_id}>
            <p>{reverseName(voiceActor.person.name)} </p>
            
            <a
              href={voiceActor.person.url}
              target="_blank"
              rel="noopener noreferrer"
            >
              <img
                src={voiceActor.person.images.jpg.image_url}
                alt={voiceActor.person.name}
              />         
            </a>
            <p> 
              <Link to={`/charactervoicedetails/${voiceActor.person.mal_id}`}> 
              {voiceActor.language}</Link> 
            </p>    
          </VoiceActorCard>
        ))}
      </div>
    </div>
  );
}

export default VoiceActorList;
