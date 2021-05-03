export default function EmbeddedConsole() {
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
                        <option value="frontPage" selected>
                            Front page
                        </option>
                    </select>
                </div>
                <input type="hidden" name="_csrf" value="<%- csrfToken %>"></input>
                <button type="submit" className="btn btn-docu">Submit</button>
            </form>
        </div>
    );
}
