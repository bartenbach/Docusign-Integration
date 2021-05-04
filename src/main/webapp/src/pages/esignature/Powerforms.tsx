import BattlePlanSalary from "./BattlePlanSalary";
import LienWaiver from "./LienWaiver";

export default function Powerforms() {
    return (        
    <div className="container">  
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
            integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
            crossOrigin="anonymous"
        ></link>
        <div>
            <br></br>
            <LienWaiver />
            <br></br>
            <BattlePlanSalary />
        </div>
    </div>  
    );
}