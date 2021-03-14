import { Button } from "@material-ui/core";

export const BtButton: React.FC<Props> = (props) => {
  return <Button onClick={props.onClick()} href={props.href}>{props.text}</Button>
};

interface Props {
  text: string;
  href?: string;
  onClick: Function;
}

export default BtButton;
