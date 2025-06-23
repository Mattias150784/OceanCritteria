package net.mattias.oceancritteria.entity.client;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.mattias.oceancritteria.entity.animations.ModAnimationDefinitions;
import net.mattias.oceancritteria.entity.custom.PenguinEntity;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class PenguinModel<T extends Entity> extends HierarchicalModel<T> {

	private final ModelPart penguin;
	private final ModelPart body;
	private final ModelPart lw;
	private final ModelPart rw;
	private final ModelPart tail;
	private final ModelPart tailfeather;
	private final ModelPart head;
	private final ModelPart rf;
	private final ModelPart lf;
	private final ModelPart baby;
	private final ModelPart bodyb;
	private final ModelPart rwingb;
	private final ModelPart lwingb;
	private final ModelPart bhead;
	private final ModelPart rfootb;
	private final ModelPart lfootb;

	public PenguinModel(ModelPart root) {
		this.penguin = root.getChild("penguin");
		this.body = this.penguin.getChild("body");
		this.lw = this.body.getChild("lw");
		this.rw = this.body.getChild("rw");
		this.tail = this.body.getChild("tail");
		this.tailfeather = this.tail.getChild("tailfeather");
		this.head = this.body.getChild("head");
		this.rf = this.penguin.getChild("rf");
		this.lf = this.penguin.getChild("lf");
		this.baby = root.getChild("baby");
		this.bodyb = this.baby.getChild("bodyb");
		this.rwingb = this.bodyb.getChild("rwingb");
		this.lwingb = this.bodyb.getChild("lwingb");
		this.bhead = this.bodyb.getChild("bhead");
		this.rfootb = this.baby.getChild("rfootb");
		this.lfootb = this.baby.getChild("lfootb");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition penguin = partdefinition.addOrReplaceChild("penguin", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = penguin.addOrReplaceChild("body", CubeListBuilder.create().texOffs(1, 1).addBox(-3.5F, -5.5F, -3.0F, 7.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.5F, 1.0F));

		PartDefinition lw = body.addOrReplaceChild("lw", CubeListBuilder.create().texOffs(24, 20).addBox(-0.5F, -1.0F, -1.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -2.5F, 0.5F));

		PartDefinition rw = body.addOrReplaceChild("rw", CubeListBuilder.create().texOffs(24, 20).mirror().addBox(-0.5F, -1.0F, -1.5F, 1.0F, 8.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -2.5F, 0.5F));

		PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(19, 41).addBox(-2.5F, 0.3F, 0.025F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.2F, 2.975F));

		PartDefinition tailfeather = tail.addOrReplaceChild("tailfeather", CubeListBuilder.create().texOffs(21, 38).addBox(-2.5F, 0.0F, -0.025F, 5.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.3F, 1.05F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(29, 16).addBox(-1.0F, -2.5F, -7.925F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(1, 19).addBox(-2.5F, -4.5F, -4.925F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 1.925F));

		PartDefinition rf = penguin.addOrReplaceChild("rf", CubeListBuilder.create(), PartPose.offsetAndRotation(-2.85F, -0.5F, -0.275F, 0.0F, -0.2618F, 0.0F));

		PartDefinition rf_r1 = rf.addOrReplaceChild("rf_r1", CubeListBuilder.create().texOffs(31, 4).addBox(-1.0F, -0.5F, -2.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.1F, 0.0F, 0.025F, 0.0F, 0.2618F, 0.0F));

		PartDefinition lf = penguin.addOrReplaceChild("lf", CubeListBuilder.create().texOffs(31, 4).mirror().addBox(-2.1F, -0.5F, -2.05F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.6F, -0.5F, -0.45F));

		PartDefinition baby = partdefinition.addOrReplaceChild("baby", CubeListBuilder.create(), PartPose.offset(0.0F, 20.0F, 0.0F));

		PartDefinition bodyb = baby.addOrReplaceChild("bodyb", CubeListBuilder.create().texOffs(41, 52).addBox(-2.9F, -6.9962F, -1.0755F, 6.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 2.9962F, -0.1745F));

		PartDefinition rwingb = bodyb.addOrReplaceChild("rwingb", CubeListBuilder.create(), PartPose.offset(-3.275F, -6.0F, 1.5F));

		PartDefinition cube_r1 = rwingb.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(51, 36).addBox(-0.5F, -3.0F, -1.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.125F, 3.0038F, -0.0755F, 0.0F, 0.0F, 0.1745F));

		PartDefinition lwingb = bodyb.addOrReplaceChild("lwingb", CubeListBuilder.create(), PartPose.offset(2.225F, -6.225F, 1.5F));

		PartDefinition cube_r2 = lwingb.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(51, 36).mirror().addBox(-0.5F, -3.0F, -1.5F, 1.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.375F, 3.2288F, -0.0755F, 0.0F, 0.0F, -0.1745F));

		PartDefinition bhead = bodyb.addOrReplaceChild("bhead", CubeListBuilder.create().texOffs(14, 57).addBox(-0.9F, -1.4962F, -4.8255F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(22, 46).addBox(-1.9F, -3.7462F, -4.0755F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.01F))
				.texOffs(23, 56).addBox(-1.9F, -3.9962F, -4.0755F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 3.0F));

		PartDefinition rfootb = baby.addOrReplaceChild("rfootb", CubeListBuilder.create().texOffs(2, 38).addBox(-0.9F, -0.4962F, -2.0755F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.1F, 3.4962F, -0.1745F));

		PartDefinition lfootb = baby.addOrReplaceChild("lfootb", CubeListBuilder.create().texOffs(2, 38).addBox(-0.9F, -0.4962F, -2.0755F, 2.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(1.9F, 3.4962F, -0.1745F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch, ageInTicks);

		if (entity.isInWater()) {
			boolean isResurfacing = entity.getDeltaMovement().y > 0.1 && isNearWaterSurface((PenguinEntity) entity);
			if (isResurfacing) this.applyResurfacingPose(ageInTicks);
			else this.animate(((PenguinEntity) entity).swimAnimationState, ModAnimationDefinitions.PENGUIN_SWIM, ageInTicks, 1f);
		} else {
			this.animateWalk(ModAnimationDefinitions.PENGUIN_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
			this.animate(((PenguinEntity) entity).idleAnimationState, ModAnimationDefinitions.PENGUIN_IDLE, ageInTicks, 1f);
		}
	}

	private boolean isNearWaterSurface(PenguinEntity penguin) {
		return penguin.level().getBlockState(penguin.blockPosition().above()).isAir() ||
				penguin.level().getBlockState(penguin.blockPosition().above(2)).isAir();
	}

	private void applyResurfacingPose(float ageInTicks) {
		float tiltAngle = (float) Math.PI / 4.0f;

		float oscillation = Mth.sin(ageInTicks * 0.1f) * 0.05f;
		this.penguin.xRot = -tiltAngle + oscillation;

		this.lw.zRot = -0.2f;
		this.rw.zRot = 0.2f;

		this.tail.xRot = 0.1f;

		this.lf.xRot = 0.3f;
		this.rf.xRot = 0.3f;

		float wingFlap = Mth.sin(ageInTicks * 0.3f) * 0.15f;
		this.lw.xRot = wingFlap;
		this.rw.xRot = wingFlap;
	}

	private void applyHeadRotation(float pNetHeadYaw, float pHeadPitch, float pAgeInTicks) {
		pNetHeadYaw = Mth.clamp(pNetHeadYaw, -30.0F, 30.0F);
		pHeadPitch = Mth.clamp(pHeadPitch, -25.0F, 45.0F);

		this.head.yRot = pNetHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = pHeadPitch * ((float)Math.PI / 180F);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		penguin.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		baby.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return penguin;
	}
}