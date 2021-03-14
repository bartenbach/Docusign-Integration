const token_url: string = "ihttps://account-d.docusign.com/oauth/auth?response_type=code&scope=signature"
const client_id: string = "5f178629-92f1-431f-a323-3b6852e823a0"
const state: string = ""
const redirect: string = ""

const Document = () => {
    var url = token_url + "&client_id=" + client_id + "&state=" + state + "&redirect_uri=" + redirect
    fetch(url)
    return (
        <div>
        </div>
    )
}

export default Document
