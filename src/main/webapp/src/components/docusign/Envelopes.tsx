import BtButton from "../shared/BtButton";

export default function Envelopes() {
    return (
        <div>
            <BtButton text="Get My Envelopes" link="/ds/envelopes/get"/>
            <BtButton text="Send Envelope" link="/ds/envelopes/send"/>
        </div>
    );
}
