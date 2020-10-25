const loginContainer = document.getElementById('auth-container');

loginContainer.addEventListener('click', event => {
  const current = event.target;

  if (current.nodeName.toLowerCase() === 'button' && current.classList.contains('delete')) {
    current.parentElement.hidden = true;
  }
});
