import { Box, Button } from "@material-ui/core";
import React from "react";

export const BtButton: React.FC<Props> = (props) => {
  return (
    <Box m={1} display="inline-block">
      <Button
        className={props.className}
        variant="contained"
        color="primary"
        href={props.link}
        type={props.type}
        onClick={props.clickfn}
      >
        {props.text}
      </Button>
    </Box>
  );
};

interface Props {
  text: string;
  link: string;
  type?: string;
  clickfn?: any;
  className?: string;
}

export default BtButton;
