import { Button } from "@material-ui/core";

export const BtButton: React.FC<Props> = (props) => {
  return <Button onClick={props.onClick()}>{props.text}</Button>
};

interface Props {
  text: string;
  onClick: Function;
}

export default BtButton;
