window.onload = function() {
    let message = document.getElementById('cracked_message');
    let value = localStorage.getItem('cracked_message');
    message.innerHTML = value;
};