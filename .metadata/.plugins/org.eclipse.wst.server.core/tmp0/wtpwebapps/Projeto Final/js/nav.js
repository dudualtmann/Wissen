// nav.js
const navSlide = () =>{
    const burger = $('.burger').get(0);
    const nav = $('.nav-links').get(0);
    const navLinks = document.querySelectorAll('.nav-links li');
    const navLinks2 = $('nav-links li');

    
    burger.addEventListener('click', () => {
        // Toggle Nav
        nav.classList.toggle('nav-active');
        // Animated Links
        navLinks.forEach((link,index) => {
        if(link.style.animation){
            link.style.animation = '';
        }
        else{
            link.style.animation =  `navLinkFade 0.5s ease forwards ${index/5+0.5}s`;
        }
        
    });
    });

    $(document).on('click', '.nav-links li a', function(){
        // Toggle Nav
        nav.classList.toggle('nav-active');
        // Animated Links
        navLinks.forEach((link,index) => {
        if(link.style.animation){
            link.style.animation = '';
        }
        else{
            link.style.animation =  `navLinkFade 0.5s ease forwards ${index/5+0.5}s`;
        }
        
    });
    })

    
    
    
    
}

navSlide();