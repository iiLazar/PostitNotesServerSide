let notes = '';
let noteArr = [];
let i = 0;

function modalDel() {
    showElement('modal');
    hideElement('editBtn');
    showElement('createBtn');
    textAreaDefaultColor();
    textAreaDefaultText();
}

function deleteAll() {
    window.location.href='deleteAll';
    hideElement('delBtn');
    hideElement('modal');
}

function showElement(el) {
    document.getElementById(el).style.display = 'block';
}

function hideElement(el) {
    document.getElementById(el).style.display = 'none';
}

function textAreaDefaultColor() {
    document.getElementById('text').style.backgroundColor = '#c2d1f0';
}

if (document.getElementById('tudu')) {
	showElement('delBtn');
} else {
	hideElement('delBtn');
}

// zasto ne radi...???
document.getElementsByClassName('close')[0].onclick = hideElement('modal');
document.getElementById('closeModalBtn').onclick = hideElement('modal');
window.onclick = function(k) {
    if (k.target == document.getElementById('modal')) {
        hideElement('modal');
    }
}
document.addEventListener("keydown", function(k) {
    if (k.which === 27) {
        hideElement('modal');
    }
})