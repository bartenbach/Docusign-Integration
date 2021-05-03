export default function EmbeddedSending() {
    return (
        <div className="container">
            <link
                rel="stylesheet"
                href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
                integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
                crossOrigin="anonymous"
            ></link>
            <form className="eg" action="" method="post" data-busy="form">
                <div className="form-group">
                    <label htmlFor="startingView">Starting View</label>
                    <select
                        id="startingView"
                        name="startingView"
                        className="form-control"
                    >
                        <option value="tagging" selected>
                            Tagging view
                        </option>
                        <option value="recipient">Recipient &amp; Documents view</option>
                    </select>
                </div>
                <div className="form-group">
                    <label htmlFor="signerEmail">Signer Email</label>
                    <input
                        type="email"
                        id="signerEmail"
                        name="signerEmail"
                        className="form-control"
                        placeholder="email@domain.com"
                    ></input>
                </div>
                <div className="form-group">
                    <label htmlFor="signerName">Signer Name</label>
                    <input
                        type="text"
                        id="signerName"
                        placeholder="FirstName LastName"
                        className="form-control"
                        name="signerName"
                    ></input>
                </div>
                <div className="form-group">
                    <label htmlFor="ccEmail">CC Email</label>
                    <input
                        type="email"
                        id="ccEmail"
                        className="form-control"
                        name="ccEmail"
                        placeholder="email@domain.com"
                        required
                    ></input>
                </div>
                <div className="form-group">
                    <label htmlFor="ccName">CC Name</label>
                    <input
                        type="text"
                        id="ccName"
                        placeholder="FirstName LastName"
                        className="form-control"
                        name="ccName"
                        required
                    ></input>
                </div>
                <input type="hidden" name="_csrf" value="<%- csrfToken %>"></input>
                <button type="submit" className="btn btn-docu">Submit</button>
            </form>
        </div>
    );
}
