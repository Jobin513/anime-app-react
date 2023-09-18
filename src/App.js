import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import Home from './components/Home';
import CharacterList from './components/CharacterList';
import VoiceActorList from './components/VoiceActorList';
import CharacterVoiceDetails from './components/CharacterVoiceDetails';

function App() {
  const [characterName, setCharacterName] = useState('');

  const handleSearch = (name) => {
    setCharacterName(name);
  };

  return (
    <Router basename="/anime-app-react">
      <Routes>
        <Route path="/" element={<Home onSearch={handleSearch} />} />
        <Route path="/characterlist" element={<CharacterList characterName={characterName} />} />
        <Route path="/voiceactors/:characterID" element={<VoiceActorList />} />
        <Route path="/charactervoicedetails/:voiceActorID" element={<CharacterVoiceDetails />} />

      </Routes>
    </Router>
  );
}

export default App;
