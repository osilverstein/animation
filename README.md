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

`ACTOR_CLASS` represents objects that must be animated.  
`ACTOR_ANIMATION_CLASS` represents a raw animation itself.  
`COLOR_CLASS` represents an object's color.  
`SHAPE_CLASS` represents an object's shape itself. This can be expected to include color, dimensions.  
`LOCATION_CLASS` represents an objects location as x, y

The model contains functions facilitating the addition of a `Scene`, `Actor` or `Animation`.
It also can generate tweened animations for any attribute using functions starting with `generateEase`.

#Actor Class
This readme is under construction and will be updated within the hour. 