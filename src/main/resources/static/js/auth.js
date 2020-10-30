const authContainer = document.getElementById('auth-container');

authContainer.addEventListener('click', event => {
  const current = event.target;

  if (current.nodeName.toLowerCase() === 'button' && current.classList.contains('delete')) {
    current.parentElement.hidden = true;
  }
});
