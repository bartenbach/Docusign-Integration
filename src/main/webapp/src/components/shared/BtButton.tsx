import { Box, Button } from "@material-ui/core";
import React from "react";

export const BtButton: React.FC<Props> = (props) => {
  return (
    <Box m={1} display="inline-block">
      <Button variant="contained" color="primary" href={props.link}>
        {props.text}
      </Button>
    </Box>
  );
};

interface Props {
  text: string;
  link: string;
}

export default BtButton;
