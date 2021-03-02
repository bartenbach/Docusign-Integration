import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react button', () => {
  render(<App />);
  const buttonElement = screen.getByText(/Fetch API/i);
  expect(buttonElement).toBeInTheDocument();
});
