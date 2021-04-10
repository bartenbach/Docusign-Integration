export default function embeddedConsole() {
    return (
        <form className="eg" action="" method="post" data-busy="form">
        <div className="form-group">
            <label htmlFor="startingView">Starting View</label>
            <select id="startingView" name="startingView" className="form-control">
                <option value="frontPage" selected>Front page</option>
            </select>
        </div>
        <input type="hidden" name="_csrf" value="<%- csrfToken %>"></input>
        <button type="submit" className="btn btn-docu">Continue</button>
        </form>
    );
  }