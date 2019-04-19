document.addEventListener("DOMContentLoaded", function() {
    openButton = document.getElementById("open-group");

    openButton.onclick = function () {
        console.log("asd");
        groups = document.getElementById("group-list");
        groups.style.display = (groups.style.display == 'none') ? 'block' : 'none';
    }
});