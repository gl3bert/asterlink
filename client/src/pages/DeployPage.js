import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

function DeployPage() {
  const [imageUrl, setImageUrl] = useState('');
  const [countdown, setCountdown] = useState(10); // Initialize countdown at 10
  const [timerStarted, setTimerStarted] = useState(false); // To start countdown after 10 seconds
  const navigate = useNavigate();

  // Handle the countdown timer
  useEffect(() => {
    if (timerStarted && countdown > 0) {
      const timer = setInterval(() => {
        setCountdown((prev) => prev - 1);
      }, 1000);

      // Clear the interval when countdown reaches zero or on component unmount
      return () => clearInterval(timer);
    }
  }, [timerStarted, countdown]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      // Make the POST request to /image/process
      const response = await fetch('/image/process', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ url: imageUrl }),
      });

      if (response.ok) {
        // Redirect to /image/result if the request was successful
        navigate('/image/result');
      } else {
        // Handle error response
        console.error('Error processing image');
      }
    } catch (error) {
      // Handle fetch error
      console.error('Network error:', error);
    }
  };

  // Start countdown after 10 seconds
  useEffect(() => {
    const countdownTimer = setTimeout(() => {
      setTimerStarted(true); // Start the timer after 10 seconds
    }, 10000);

    // Cleanup timeout if the component unmounts
    return () => clearTimeout(countdownTimer);
  }, []);

  return (
    <div className="deployPage">
      <h1><a href="https://colab.research.google.com/drive/1padeMU0qikjjpB1PbXEICvulfO5XlyuY?usp=sharing">Deployment!</a></h1>
    </div>
  );
}

export default DeployPage;
