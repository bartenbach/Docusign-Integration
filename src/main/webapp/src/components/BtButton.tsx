import { Button } from "@material-ui/core";
import React from "react";

export const BtButton: React.FC<Props> = (props) => {
  return (
    <Button variant="contained" color="primary" href={props.link}>
      {props.text}
    </Button>
  );
};

interface Props {
  text: string;
  link: string;
}

export default BtButton;
