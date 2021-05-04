import BattlePlanSalary from "./BattlePlanSalary";
import LienWaiver from "./LienWaiver";


export default function EmbeddedSending() {
    return (
    <div className="container">  
        <div>
            <LienWaiver />
        </div>
        <div>
            <BattlePlanSalary />
        </div>  
    </div>  
    )
}