fetch('/chat', {
        method: 'POST',
        headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
        body: 'message=Hello, ChatMate!'
    })
    .then(response => response.json())
    .then(data => console.log(data.response))
    .catch(error => console.error('Error:', error));