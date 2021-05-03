export default function EmbeddedSigning() {
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
                    <label htmlFor="signerEmail">Signer Email</label>
                    <input type="email" className="form-control"  id="signerEmail"
                        name="signerEmail" placeholder="email@domain.com" required >
                    </input>
                    <small id="emailHelp" className="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div className="form-group">
                    <label htmlFor="signerName">Signer Name</label>
                    <input
                        type="test" className="form-control" id="signerName"
                        placeholder="FirstName LastName" name="signerName" required>
                    </input>
                </div>
                <input type="hidden" name="_csrf" value="${csrfToken}"></input>
                <button type="submit" className="btn btn-docu">Submit</button>
            </form>
        </div>
    );
}