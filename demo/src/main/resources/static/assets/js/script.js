'use strict';
 
// PRELOAD
// loading will be ending after document is loaded: works

const preloader=document.querySelector('[data-preaload]');
window.addEventListener('load', function(){
    preloader.classList.add('loaded');
    document.body.classList.add("loaded");
});

// add event listener on multiple element
function addEventOnELements (elements, eventType, callback){
    for(let i=0;i<elements.lenght;i++){
        elements[i].addEventListener(eventType,callback);
    }
}


// NAVBAR

const navbar=document.querySelector('[data-navbar]');
const navTogglers=document.querySelectorAll('[data-nav-toggler]');
const overlay=document.querySelector('[data-overlay]');

const toggleNavbar=function(){
    navbar.classList.toggle('active');
    // console.log(navbar.classList)
    overlay.classList.toggle('active');
    document.body.classList.toggle('nav-active');
    // console.log("hey")
}
for(let i=0; i<navTogglers.length;i++){
    navTogglers[i].addEventListener('click',toggleNavbar)
}
// addEventOnELements(navTogglers, 'click',toggleNavbar)


// HEADER

const header=document.querySelector('[data-header]');

let lastScrollPos=0;

const hideHeader= function(){
const isScrollButton=lastScrollPos<window.scrollY;
if(isScrollButton){
    header.classList.add('hide')
}else{
    header.classList.remove('hide');
}
lastScrollPos=window.scrollY;
}

window.addEventListener('scroll', function(){
    if(window.scrollY>=50){
        header.classList.add('active');
        hideHeader();
    }else{
        header.classList.remove('active');
    }
})






// HERO SLIDER

const heroSlider=document.querySelector("[data-hero-slider]");
const heroSliderItems=document.querySelectorAll("[data-hero-slider-item]");
const heroSliderPrevBtn= document.querySelector("[data-prev-btn]");
const heroSliderNextBtn=document.querySelector("[data-next-btn]");

let currentSlidePos=0;
let lastActiveSliderItem=heroSliderItems[0];

console.log(`last position:${lastActiveSliderItem.classList}`)
console.log(`current position:${currentSlidePos}`)
console.log(currentSlidePos=heroSliderItems.length -1)
const slideNext=function(){
    if(currentSlidePos==heroSliderItems.length -1 ){
        currentSlidePos=0;
        console.log(`slidenext reset + position:${currentSlidePos}`)
    }else{
        currentSlidePos++
        console.log("slidenext next")
    }
    updateSliderPos();
}

const updateSliderPos=function(){
    lastActiveSliderItem.classList.remove('active');
    console.log(`last position:${lastActiveSliderItem.classList}`)
    heroSliderItems[currentSlidePos].classList.add('active');
    lastActiveSliderItem=heroSliderItems[currentSlidePos];
}

heroSliderNextBtn.addEventListener('click', slideNext);

const slidePrev= function(){
    if(currentSlidePos<=0 ){
        currentSlidePos=heroSliderItems.length-1;
        console.log("slideprev reset")
    }else{
        currentSlidePos--;
        console.log("slideprev prev")
    }
    updateSliderPos();
}

heroSliderPrevBtn.addEventListener('click', slidePrev);


// auto slide
let autoSlideInterval;

const autoSlide=function(){
    autoSlideInterval=setInterval(function(){
        slideNext();},7000)
    }

    heroSliderNextBtn.addEventListener('mouseover',function(){
        clearInterval(autoSlideInterval)
    });
    heroSliderPrevBtn.addEventListener('mouseover', function(){
        clearInterval(autoSlideInterval)
    });

    // addEventOnELements([heroSliderNextBtn, heroSliderPrevBtn], 'mouseover', function(){
    //     clearInterval(autoSlideInterval)
    // });

    heroSliderNextBtn.addEventListener('mouseout', autoSlide);
    heroSliderPrevBtn.addEventListener('mouseout', autoSlide);

    // addEventOnELements([heroSliderNextBtn, heroSliderPrevBtn], 'mouseout', autoSlide)

    window.addEventListener('load', autoSlide)
    
