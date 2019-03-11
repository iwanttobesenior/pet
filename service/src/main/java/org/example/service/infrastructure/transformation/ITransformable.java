package org.example.service.infrastructure.transformation;

/**
 * Transformation behavior
 *
 * @author Kul'baka Alex
 */
public interface ITransformable<P> {

    void transform(final P p);

    P unTransform(final P p);
}
