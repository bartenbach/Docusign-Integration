import React from 'react';
import logo from './logo.svg';
import './App.css';

function base64ToBlob(base64: string) {
    const binaryString = window.atob(base64);
    const len = binaryString.length;
    const bytes = new Uint8Array(len);
    for (let i = 0; i < len; ++i) {
        bytes[i] = binaryString.charCodeAt(i);
    }

    return new Blob([bytes], { type: 'application/pdf' });
}

function getApi() {
  console.log('The \'Get Api\' button was clicked!');
  fetch('/api/all')
      .then(response => response.json())
      .then(data => {
          console.log(data);
          // @ts-ignore
          document.getElementById('builderName').textContent = data[0].builderName;
          // @ts-ignore
          document.getElementById('pdfDoc').src = URL.createObjectURL(base64ToBlob(data[0].document));
      })
      .catch(err => console.error(err));
  console.log('Everything was done.');
}

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <div className="col-right">
          <img src={logo} className="App-logo" alt="logo" />
          <p>Edit <code>src/App.js</code> and save to reload.</p>
          <button onClick={getApi}>Fetch API</button>
        </div>
        <div className="col-left">
          <p><code>PDF Author:</code> <code id="builderName"></code></p>
          <iframe id="pdfDoc" src=""></iframe>
        </div>
      </header>
    </div>
  );
}

export default App;
