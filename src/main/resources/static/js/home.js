window.onscroll = function() {
  var header = document.getElementById('header');
  if (window.scrollY > 50) {
    header.classList.add('bg-white');
  } else {
    header.classList.remove('bg-white');
  }
}