const sendMessage = async (message) => {
    const response = await fetch('/chat', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: `message=${encodeURIComponent(message)}`
    });
    const data = await response.json();
    console.log('Bot response:', data.response);
};
