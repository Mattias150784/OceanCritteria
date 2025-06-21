package net.mattias.oceancritteria.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ModAnimationDefinitions {

        public static final AnimationDefinition PENGUIN_IDLE = AnimationDefinition.Builder.withLength(2.0F).looping()
                .addAnimation("lw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -20.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -10.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-0.8F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(-0.8F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(-0.8F, 0.7F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(-0.8F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 20.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 10.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.8F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.posVec(0.8F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.8F, 0.7F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.8F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(1.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.05F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -0.25F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -0.25F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9167F, KeyframeAnimations.degreeVec(3.4999F, -0.0305F, 0.4991F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(3.4999F, -0.0305F, 0.4991F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -0.25F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -0.25F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0833F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9167F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(1.25F, -0.0109F, 0.2498F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, -0.125F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailfeather", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-7.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0417F, KeyframeAnimations.degreeVec(-7.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(7.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.9583F, KeyframeAnimations.degreeVec(-7.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(-7.25F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bodyb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0417F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rwingb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lwingb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bhead", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bhead", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.9583F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(1.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.1F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(2.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition PENGUIN_WALK = AnimationDefinition.Builder.withLength(0.95F).looping()
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(2.5095F, 4.9952F, -2.2813F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.05F, KeyframeAnimations.degreeVec(2.5095F, 4.9952F, -2.2813F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.45F, KeyframeAnimations.degreeVec(2.5095F, -4.9952F, 2.2813F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(2.5095F, -4.9952F, 2.2813F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(2.5095F, 4.9952F, -2.2813F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(1.7538F, -9.8466F, -25.1511F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.45F, KeyframeAnimations.degreeVec(0.8804F, -9.9616F, -20.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(1.7538F, -9.8466F, -25.1511F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-0.7F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.posVec(-0.7F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.8804F, 9.9616F, 20.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.45F, KeyframeAnimations.degreeVec(1.7103F, 9.8533F, 24.8897F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.8804F, 9.9616F, 20.0767F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.7F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.posVec(0.7F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailfeather", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.25F, KeyframeAnimations.degreeVec(-2.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.55F, KeyframeAnimations.degreeVec(7.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.075F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.08F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.005F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rf", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1F, KeyframeAnimations.degreeVec(5.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.15F, KeyframeAnimations.degreeVec(10.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.degreeVec(7.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4F, KeyframeAnimations.degreeVec(-2.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-3.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.65F, KeyframeAnimations.degreeVec(1.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-1.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rf", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.3F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, 0.125F, 0.43F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.15F, KeyframeAnimations.posVec(0.0F, 0.2F, 0.48F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.43F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.posVec(0.0F, 0.35F, 0.08F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4F, KeyframeAnimations.posVec(0.0F, 0.35F, -0.47F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.25F, -0.535F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.65F, KeyframeAnimations.posVec(0.0F, 0.025F, -0.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.03F, -0.475F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.3F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lf", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.degreeVec(1.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.degreeVec(-1.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.45F, KeyframeAnimations.degreeVec(3.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.55F, KeyframeAnimations.degreeVec(2.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.65F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-7.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(-10.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.85F, KeyframeAnimations.degreeVec(-5.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lf", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.posVec(0.0F, 0.03F, 0.475F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.posVec(0.0F, 0.025F, 0.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.45F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.535F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.55F, KeyframeAnimations.posVec(0.0F, 0.35F, 0.47F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.65F, KeyframeAnimations.posVec(0.0F, 0.35F, -0.08F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.25F, -0.43F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.posVec(0.0F, 0.2F, -0.48F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.85F, KeyframeAnimations.posVec(0.0F, 0.125F, -0.43F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bodyb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 2.5F, -2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(0.0F, -2.5F, 2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, 2.5F, -2.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rfootb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1F, KeyframeAnimations.degreeVec(5.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.15F, KeyframeAnimations.degreeVec(10.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.degreeVec(7.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4F, KeyframeAnimations.degreeVec(-2.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-3.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.65F, KeyframeAnimations.degreeVec(1.5F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-1.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, 10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rfootb", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.3F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1F, KeyframeAnimations.posVec(0.0F, 0.125F, 0.43F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.15F, KeyframeAnimations.posVec(0.0F, 0.2F, 0.48F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.43F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.posVec(0.0F, 0.35F, 0.08F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4F, KeyframeAnimations.posVec(0.0F, 0.35F, -0.47F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.posVec(0.0F, 0.25F, -0.535F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.65F, KeyframeAnimations.posVec(0.0F, 0.025F, -0.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.03F, -0.475F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.posVec(0.0F, 0.0F, 0.3F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lfootb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.degreeVec(1.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.degreeVec(-1.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.45F, KeyframeAnimations.degreeVec(3.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.55F, KeyframeAnimations.degreeVec(2.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.65F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.degreeVec(-7.5F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(-10.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.85F, KeyframeAnimations.degreeVec(-5.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, -10.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lfootb", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.posVec(0.0F, 0.03F, 0.475F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.posVec(0.0F, 0.025F, 0.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.45F, KeyframeAnimations.posVec(0.0F, 0.25F, 0.535F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.55F, KeyframeAnimations.posVec(0.0F, 0.35F, 0.47F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.65F, KeyframeAnimations.posVec(0.0F, 0.35F, -0.08F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.75F, KeyframeAnimations.posVec(0.0F, 0.25F, -0.43F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.posVec(0.0F, 0.2F, -0.48F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.85F, KeyframeAnimations.posVec(0.0F, 0.125F, -0.43F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.posVec(0.0F, 0.0F, -0.3F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rwingb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.45F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lwingb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.45F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -5.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.95F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();

        public static final AnimationDefinition PENGUIN_SWIM = AnimationDefinition.Builder.withLength(0.8F).looping()
                .addAnimation("penguin", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-2.4976F, -0.109F, 0.0024F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4F, KeyframeAnimations.degreeVec(2.5F, 0.0F, -2.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6F, KeyframeAnimations.degreeVec(-2.4976F, -0.109F, 0.0024F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("penguin", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -2.975F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.posVec(0.0F, -2.975F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("body", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(92.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4F, KeyframeAnimations.degreeVec(92.4976F, -0.109F, 2.4976F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-44.4734F, -11.603F, -22.4304F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0667F, KeyframeAnimations.degreeVec(-73.0285F, -76.7667F, 11.0165F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1F, KeyframeAnimations.degreeVec(-199.7546F, -79.2802F, 132.6277F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-237.1698F, -46.2613F, 168.0756F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2333F, KeyframeAnimations.degreeVec(-239.9115F, -62.1416F, 171.4233F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2667F, KeyframeAnimations.degreeVec(-332.4205F, -81.622F, 268.2459F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.degreeVec(-77.153F, -64.3909F, 7.1546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3667F, KeyframeAnimations.degreeVec(-61.92F, -31.69F, -9.36F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4F, KeyframeAnimations.degreeVec(-44.4734F, -11.603F, -22.4304F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4667F, KeyframeAnimations.degreeVec(-73.0285F, -76.7667F, 11.0165F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-199.7546F, -79.2802F, 132.6277F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5667F, KeyframeAnimations.degreeVec(-237.1698F, -46.2613F, 168.0756F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6333F, KeyframeAnimations.degreeVec(-239.9115F, -62.1416F, 171.4233F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-332.4205F, -81.622F, 268.2459F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7F, KeyframeAnimations.degreeVec(-77.153F, -64.3909F, 7.1546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7667F, KeyframeAnimations.degreeVec(-61.92F, -31.69F, -9.36F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(-44.4734F, -11.603F, -22.4304F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.725F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.725F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rw", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-44.4734F, 11.603F, 22.4304F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.0667F, KeyframeAnimations.degreeVec(-73.0285F, 76.7667F, -11.0165F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1F, KeyframeAnimations.degreeVec(-199.7546F, 79.2802F, -132.6277F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.degreeVec(-237.1698F, 46.2613F, -168.0756F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2333F, KeyframeAnimations.degreeVec(-239.9115F, 62.1416F, -171.4233F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2667F, KeyframeAnimations.degreeVec(-332.4205F, 81.622F, -268.2459F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.degreeVec(-77.153F, 64.3909F, -7.1546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3667F, KeyframeAnimations.degreeVec(-61.92F, 31.69F, 9.36F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4F, KeyframeAnimations.degreeVec(-44.4734F, 11.603F, 22.4304F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4667F, KeyframeAnimations.degreeVec(-73.0285F, 76.7667F, -11.0165F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5F, KeyframeAnimations.degreeVec(-199.7546F, 79.2802F, -132.6277F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5667F, KeyframeAnimations.degreeVec(-237.1698F, 46.2613F, -168.0756F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6333F, KeyframeAnimations.degreeVec(-239.9115F, 62.1416F, -171.4233F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6667F, KeyframeAnimations.degreeVec(-332.4205F, 81.622F, -268.2459F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7F, KeyframeAnimations.degreeVec(-77.153F, 64.3909F, -7.1546F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7667F, KeyframeAnimations.degreeVec(-61.92F, 31.69F, 9.36F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(-44.4734F, 11.603F, 22.4304F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rw", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.725F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4F, KeyframeAnimations.posVec(0.0F, 0.0F, -2.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6F, KeyframeAnimations.posVec(0.0F, 0.0F, -1.725F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3667F, KeyframeAnimations.degreeVec(-95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(-75.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tail", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.85F, 0.325F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("tailfeather", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2333F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.4667F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.6333F, KeyframeAnimations.degreeVec(-5.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(22.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.2F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3667F, KeyframeAnimations.degreeVec(-87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5667F, KeyframeAnimations.degreeVec(-90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7667F, KeyframeAnimations.degreeVec(-87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("head", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, 0.275F, -4.375F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rf", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(37.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rf", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.5F, 6.0F, 7.45F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.posVec(0.5F, 6.0F, 7.45F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lf", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(32.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(27.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lf", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(-0.325F, 6.0F, 7.625F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.posVec(-0.325F, 6.0F, 7.625F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("baby", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(100.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(90.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(100.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("baby", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -3.0F, 3.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.posVec(0.0F, -3.0F, 3.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rwingb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 27.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, 7.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lwingb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.1667F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.5333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -27.5F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.7333F, KeyframeAnimations.degreeVec(0.0F, 0.0F, -7.5F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bhead", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(-87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3F, KeyframeAnimations.degreeVec(-95.0F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(-87.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("bhead", new AnimationChannel(AnimationChannel.Targets.POSITION,
                        new Keyframe(0.0F, KeyframeAnimations.posVec(0.0F, -0.225F, -3.575F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("rfootb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(72.6407F, 2.2494F, 7.1566F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3667F, KeyframeAnimations.degreeVec(82.4789F, -0.0983F, 2.5729F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(72.6407F, 2.2494F, 7.1566F), AnimationChannel.Interpolations.LINEAR)
                ))
                .addAnimation("lfootb", new AnimationChannel(AnimationChannel.Targets.ROTATION,
                        new Keyframe(0.0F, KeyframeAnimations.degreeVec(72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.3667F, KeyframeAnimations.degreeVec(82.5156F, -0.7515F, -2.3844F), AnimationChannel.Interpolations.LINEAR),
                        new Keyframe(0.8F, KeyframeAnimations.degreeVec(72.5F, 0.0F, 0.0F), AnimationChannel.Interpolations.LINEAR)
                ))
                .build();
}