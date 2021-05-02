import BtButton from "../shared/BtButton";

export default function Login() {
    return (
        <div>
            <BtButton text="Homeowner" link="/login"/>
            <BtButton text="Builder" link="/login"/>
            <div>
                <i> Not registered? </i>
                <BtButton text="Registration" link="https://go.docusign.com/sandbox/productshot/"/>
            </div>
        </div>
    );
}
