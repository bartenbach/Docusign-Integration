import BtButton from "../shared/BtButton";

export default function Envelopes() {
    return (
        <div className= "container">
        <link
        rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
        crossOrigin="anonymous"
        ></link>
            <BtButton text="Get My Envelopes" link="/ds/envelopes/get"/>
            <BtButton text="Send Envelope" link="/ds/envelopes/send"/>
        </div>
    );
}
