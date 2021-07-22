//drop-down
function dp_menu() {
    let click = document.getElementById("drop-content");
    if (click.style.display == "none" || click.style.display == "") {
        click.style.display = "block";
    } else {
        click.style.display = "none";
    }
}
//서브메뉴 마우스 오버시 확장
function expand_sub(target) {
    let hover = target;
    let atag = hover.parentNode;
    let ultag = atag.nextElementSibling;
    if (ultag.className == "submenu") {
        ultag.classList.add('added');
    }
}
//서브메뉴 마우스아웃시 축소
function undo(target) {
    let out = target.children;
    out[1].className = "submenu";
}
//content영역 변동
/*마우스오버시 본문 이동*/
function content_flow() {
    $('.nav-collapsed').attr('class', 'nav-expanded');
}
/*마우스아웃시 본문 원래대로*/
function content_flow2() {
    let name = $('.nav-expanded')[0].className;
    if (name != 'nav-expanded fixed')
        $('.nav-expanded').attr('class', 'nav-collapsed');
}

//메뉴바 고정 혹은 해제
/*고정시 확장*/
function fix_menu() {
    let wd = $('.menubar').css('width');
    if (wd == '55px') {
        $('.menubar').css('width', '196px');
        $('.menu>em').css('display', 'inline-block');
        $('.nav-collapsed').attr('class', 'nav-expanded');
        $('.nav-expanded').addClass('fixed');
    }
    /*고정 해제시 원래대로*/
    else {
        $('.menubar').css('width', '');
        $('.menu>em').css('display', '');
        $('.nav-expanded').attr('class', 'nav-collapsed');
    }
}