#ifndef MECHANICS_H
#define MECHANICS_H

/**
 * Calculates the velocity given the change in distance and time.
 *
 * @param delta_distance The change in distance.
 * @param delta_time The change in time.
 * @return The velocity.
 */
double velocity(double delta_distance, double delta_time);

/**
 * Calculates the acceleration given the change in velocity and time.
 *
 * @param delta_velocity The change in velocity.
 * @param delta_time The change in time.
 * @return The acceleration.
 */
double acceleration(double delta_velocity, double delta_time);

/**
 * Calculates the impulse given the mass and velocity.
 *
 * @param mass The mass of the object.
 * @param velocity The velocity of the object.
 * @return The impulse.
 */
double impulse(double mass, double velocity);

#endif 