import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom'; 

function Home({ onSearch }) {
  const [characterName, setCharacterName] = useState('');
  const navigate = useNavigate(); 

  
  const handleSearch = () => {
    onSearch(characterName); 
    navigate('/characterlist'); 
  };

  return (
    <div style={{
      textAlign: 'center',
      backgroundColor: 'rgba(255, 255, 200, 0.85)',
      padding: '20px',
      borderRadius: '8px',
      boxShadow: '0 0 10px rgba(0, 0, 0, 0.2)',
      marginBottom: '20px',
    }}>
      <h2>Welcome to Anime Voice Finder</h2>
      <p>Search for your favorite anime character by name:</p>
      <input
        type="text"
        placeholder="Enter character name"
        value={characterName}
        onChange={(e) => setCharacterName(e.target.value)}
      />
      <button type="button" onClick={handleSearch}>Search</button>
    </div>
  );
}

export default Home;
