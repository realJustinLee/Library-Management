(function() {
        /* Define the number of leaves to be used in the animation */
        var NUMBER_OF_LEAVES = 80;

        /*
         Called when the "Falling Leaves" page is completely loaded.
         */
        function init() {
            /* Get a reference to the element that will contain the leaves */
            var container = document.getElementById('petalbox');

            /* Fill the empty container with new leaves */
            try {
                for (var i = 0;
                     i < NUMBER_OF_LEAVES;

                     i++) {
                    container.appendChild(createALeaf());
                }
            }
            catch(e) {
            }
        }

        /*
         Receives the lowest and highest values of a range and
         returns a random integer that falls within that range.
         */
        function randomInteger(low, high) {
            return low + Math.floor(Math.random() * (high - low));
        }

        /*
         Receives the lowest and highest values of a range and
         returns a random float that falls within that range.
         */
        function randomFloat(low, high) {
            return low + Math.random() * (high - low);
        }

        /*
         Receives a number and returns its CSS pixel value.
         */
        function pixelValue(value) {
            return value + 'px';
        }

        /*
         Returns a duration value for the falling animation.
         */
        function durationValue(value) {
            return value + 's';
        }

        /*
         Uses an img element to create each leaf. "Leaves.css" implements two spin
         animations for the leaves: clockwiseSpin and counterclockwiseSpinAndFlip. This
         function determines which of these spin animations should be applied to each leaf.

         */
        function createALeaf() {
            /* Start by creating a wrapper div, and an empty img element */
            var leafDiv = document.createElement('div');
            var image = document.createElement('img');

            /* Randomly choose a leaf image and assign it to the newly created element */
            image.src ='images/hb/petal'+ randomInteger(1, 10) + '.png';

            /* Position the leaf at a random location along the screen */
            leafDiv.style.top = pixelValue(randomInteger(-200, -100));
            leafDiv.style.left = pixelValue(randomInteger(0, 1920));

            /* Randomly choose a spin animation */
            var spinAnimationName = (Math.random() < 0.5) ? 'clockwiseSpin':'counterclockwiseSpinAndFlip';        /* Set the -webkit-animation-name property with these values */
            leafDiv.style.webkitAnimationName ='fade, drop';
            leafDiv.style.animationName ='fade, drop';
            image.style.webkitAnimationName = spinAnimationName;
            image.style.animationName = spinAnimationName;

            /* 随机下落时间 */
            var fadeAndDropDuration = durationValue(randomFloat(1.2, 8.2));

            /* 随机旋转时间 */
            var spinDuration = durationValue(randomFloat(3, 4));

            leafDiv.style.webkitAnimationDuration = fadeAndDropDuration + ', ' + fadeAndDropDuration;
            leafDiv.style.animationDuration = fadeAndDropDuration + ', ' + fadeAndDropDuration;

            // 随机delay时间
            var leafDelay = durationValue(randomFloat(0, 2));

            leafDiv.style.webkitAnimationDelay = leafDelay + ', ' + leafDelay;
            leafDiv.style.animationDelay = leafDelay + ', ' + leafDelay;
            image.style.webkitAnimationDuration = spinDuration;
            image.style.animationDuration = spinDuration;
            leafDiv.appendChild(image);
            return leafDiv;
        }
        init();
    }
)();