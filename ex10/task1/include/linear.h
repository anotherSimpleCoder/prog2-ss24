#ifndef LINEAR_H
#define LINEAR_H

/**
 * Calculates the distance traveled during uniform linear motion.
 *
 * @param velocity The constant velocity of the object.
 * @param time The time duration of the motion.
 * @param start_time The initial time of the motion.
 * @return The distance traveled.
 */
double distance_of_uniform_linear_motion(double velocity, double time, double start_time);

/**
 * Calculates the distance traveled during uniformly accelerated linear motion.
 *
 * @param velocity The final velocity of the object (not typically used in distance calculation).
 * @param start_velocity The initial velocity of the object.
 * @param acceleration The constant acceleration of the object.
 * @return The distance traveled.
 */
double distance_of_uniformly_accelerated_linear_motion(double velocity, double start_velocity, double acceleration);

/**
 * Calculates the velocity of an object during uniformly accelerated linear motion.
 *
 * @param acceleration The constant acceleration of the object.
 * @param time The time duration of the motion.
 * @param start_time The initial time of the motion.
 * @param start_velocity The initial velocity of the object.
 * @return The velocity of the object.
 */
double velocity_of_uniformly_accelerated_linear_motion(double acceleration, double time, double start_time, double start_velocity);

#endif