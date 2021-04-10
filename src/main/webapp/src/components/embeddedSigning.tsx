export default function EmbeddedSigning() {
  return (
    <form action="" method="post" data-busy="form">
      <div>
      <h1>Docusign Prototype</h1>
        <label htmlFor="signerEmail">Signer Email</label>
        <input type= "email" className="form-control" id="signerEmail" name="signerEmail"
        placeholder="email@domain.com" required value="<%= locals.dsConfig.signerEmail %>">
        </input>
      </div>
      <div>
          <label htmlFor="signerName">Signer Name</label>
          <input type="test" className="form-control" id="signerName" 
          placeholder="FirstName LastName" name="signerName"
          value="<%= locals.dsConfig.signerName %>" required></input>
      </div>
      <input type="hidden" name="_csrf" value="<%- csrfToken %>"></input>
      <button type="submit" className="btn">Submit</button>
    </form>
  );
}