export default function embeddedSending() {
    return(
    <form action="" method="post" data-busy="form">
    <div>
        <label htmlFor="startingView">Starting View</label>
        <select id="startingView" name="startingView" className="form-control">
        <option value="tagging" selected>Tagging view</option>
        <option value="recipient">Recipient &amp; Documents view</option>
        </select>
    </div>
    <div>
        <label htmlFor="signerEmail">Signer Email</label>
        <input type="email" id="signerEmail" name="signerEmail" placeholder="email@domain.com"
        required value="<%= locals.dsConfig.signerEmail %>">
        </input>
    </div>
    <div>
        <label htmlFor="signerName">Signer Name</label>
        <input type="text" id="signerName" placeholder="FirstName LastName" 
        name="signerName" value="<%= locals.dsConfig.signerName %>"
        required></input>
    </div>
    <div>
        <label htmlFor="ccEmail">CC Email</label>
        <input type="email" id="ccEmail" name="ccEmail"
        placeholder="email@domain.com" required></input>
    </div>
    <div>
        <label htmlFor="ccName">CC Name</label>
        <input type="text" id="ccName" placeholder="FirstName LastName"
        name="ccName"
        required
        ></input>
    </div>
    <input type="hidden" name="_csrf" value="<%- csrfToken %>">
        <button type="submit" className="btn">Submit</button>
    </input>
    </form>
    );
}