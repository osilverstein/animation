# Animation

An animation tool made kind of from scratch. MVC madness!

# Conceptual Overview
1. Generally, an `Animation` implements an `AnimationModel`.  
2. This `Animation` has a list of objects (`Actor`) to be animated. 
3. Each actor has a `RawAnimation` specifying mutable attributes values at specific times.
From the perspective of everything except the view, time is kept using ticks and attributes are
stored in hashmaps containing relavent ticks and the value of the attribute at each tick. 
4. `RawAnimation` currently supports three mutable attributes including motion, size and color. 
More can be easily added as needed.  

# Animation Model
Provides an abstract model that can be implemented using any custom class. The model must be given
some classes for the following parameters: 

`ACTOR_CLASS, ACTOR_ANIMATION_CLASS, COLOR_CLASS, SHAPE_CLASS, LOCATION_CLASS`  

* `ACTOR_CLASS` represents objects that must be animated.  
* `ACTOR_ANIMATION_CLASS` represents a raw animation itself.  
* `COLOR_CLASS` represents an object's color.  
* `SHAPE_CLASS` represents an object's shape itself. This can be expected to include color, dimensions.  
* `LOCATION_CLASS` represents an objects location as x, y

The model contains functions facilitating the addition of a `Scene`, `Actor` or `Animation`.
It also can generate tweened animations for any attribute using functions starting with `generateEase`.  

# Actor Class  
This class represents and object to be animated. It keeps track of `shape`, `currentAttributes` and `rawAnimation`.
Generally, the actor does not keep track of time, this is done by the Animation class which feeds
a time to the actor which is rendered by updating the `currentAttributes` and rendering based on that. 

* `currentAttributes` is a HashMap containing the keys `size`, `color`, `motion`. It is associated with a specific tick.   

# Scene Class
This class represents a canvas upon which every `Actor` will be rendered.  

* `x` represents the x-dimension of the `Scene`.  
* `y` represents the y-dimention of the `Scene`.  
* `background` represents the background color of the `Scene` as a `Color`. 

# The Textual View
Content goes here.

# The SVG View
Content goes here.

# The Visual Animation View
Content goes here. 
