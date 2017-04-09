package eyeq.catspaw.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelCatsPaw extends ModelBase {
    public ModelRenderer hilt;

    public ModelRenderer hand_0;
    public ModelRenderer hand_1;
    public ModelRenderer hand_2;
    public ModelRenderer hand_3;
    public ModelRenderer pad_hand;

    public ModelRenderer finger_0_0;
    public ModelRenderer finger_1_0;
    public ModelRenderer pad_finger_0;
    public ModelRenderer nail_0;

    public ModelRenderer finger_0_1;
    public ModelRenderer finger_1_1;
    public ModelRenderer pad_finger_1;
    public ModelRenderer nail_1;

    public ModelRenderer finger_0_2;
    public ModelRenderer finger_1_2;
    public ModelRenderer pad_finger_2;
    public ModelRenderer nail_2;

    public ModelRenderer finger_0_3;
    public ModelRenderer finger_1_3;
    public ModelRenderer pad_finger_3;
    public ModelRenderer nail_3;

    public ModelCatsPaw() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        float modelPosY = 0.0F;
        this.initBase(modelPosY);
        this.initFinger0(modelPosY);
        this.initFinger1(modelPosY);
        this.initFinger2(modelPosY);
        this.initFinger3(modelPosY);
    }

    private void initBase(float posY) {
        this.hilt = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);
        this.hilt.addBox(-1F, posY, -1F, 2, 13, 2, 0.0F);

        this.hand_0 = new ModelRenderer(this, 0, 15).setTextureSize(64, 64);
        this.hand_0.addBox(-1.5F, posY - 4.0F, -1.5F, 3, 4, 3, 0.0F);
        this.hand_1 = new ModelRenderer(this, 0, 22).setTextureSize(64, 64);
        this.hand_1.addBox(-2F, posY - 5.0F, -1.5F, 4, 1, 4, 0.0F);
        this.hand_2 = new ModelRenderer(this, 0, 27).setTextureSize(64, 64);
        this.hand_2.addBox(-3F, posY - 9.0F, -1.5F, 6, 4, 4, 0.0F);
        this.hand_3 = new ModelRenderer(this, 0, 35).setTextureSize(64, 64);
        this.hand_3.addBox(-2F, posY - 10.0F, -1.5F, 4, 1, 4, 0.0F);
        this.pad_hand = new ModelRenderer(this, 32, 0).setTextureSize(64, 64);
        this.pad_hand.addBox(-1.5F, posY - 8.5F, -2F, 3, 3, 1, 0.0F);
    }

    private void initFinger0(float posY) {
        this.finger_0_0 = new ModelRenderer(this, 20, 37).setTextureSize(64, 64);
        this.finger_0_0.addBox(-1.5F, -5F, -1F, 3, 5, 2, 0.0F);
        this.finger_0_0.setRotationPoint(0F, posY - 4.0F, 0F);
        this.finger_1_0 = new ModelRenderer(this, 20, 18).setTextureSize(64, 64);
        this.finger_1_0.addBox(-1.5F, -8F, -1.6F, 3, 3, 3, 0.0F);
        this.finger_1_0.setRotationPoint(0F, posY - 4.0F, 0F);
        this.pad_finger_0 = new ModelRenderer(this, 32, 13).setTextureSize(64, 64);
        this.pad_finger_0.addBox(-1F, -7.5F, -2F, 2, 2, 1, 0.0F);
        this.pad_finger_0.setRotationPoint(0F, posY - 4.0F, 0F);
        this.nail_0 = new ModelRenderer(this, 32, 22).setTextureSize(64, 64);
        this.nail_0.addBox(-0.5F, -9F, -1F, 1, 1, 1, 0.0F);
        this.nail_0.setRotationPoint(0F, posY - 4.0F, 0F);
    }

    private void initFinger1(float posY) {
        this.finger_0_1 = new ModelRenderer(this, 20, 34).setTextureSize(64, 64);
        this.finger_0_1.addBox(-1.5F, -6F, -1F, 3, 1, 2, 0.0F);
        this.finger_0_1.setRotationPoint(0F, posY - 4.0F, 0F);
        this.finger_1_1 = new ModelRenderer(this, 20, 12).setTextureSize(64, 64);
        this.finger_1_1.addBox(-1.5F, -9F, -1.6F, 3, 3, 3, 0.0F);
        this.finger_1_1.setRotationPoint(0F, posY - 4.0F, 0F);
        this.pad_finger_1 = new ModelRenderer(this, 32, 10).setTextureSize(64, 64);
        this.pad_finger_1.addBox(-1F, -8.5F, -2F, 2, 2, 1, 0.0F);
        this.pad_finger_1.setRotationPoint(0F, posY - 4.0F, 0F);
        this.nail_1 = new ModelRenderer(this, 32, 20).setTextureSize(64, 64);
        this.nail_1.addBox(-0.5F, -10F, -1F, 1, 1, 1, 0.0F);
        this.nail_1.setRotationPoint(0F, posY - 4.0F, 0F);
    }

    private void initFinger2(float posY) {
        this.finger_0_2 = new ModelRenderer(this, 20, 31).setTextureSize(64, 64);
        this.finger_0_2.addBox(-1.5F, -6F, -1F, 3, 1, 2, 0.0F);
        this.finger_0_2.setRotationPoint(0F, posY - 4.0F, 0F);
        this.finger_1_2 = new ModelRenderer(this, 20, 6).setTextureSize(64, 64);
        this.finger_1_2.addBox(-1.5F, -9F, -1.6F, 3, 3, 3, 0.0F);
        this.finger_1_2.setRotationPoint(0F, posY - 4.0F, 0F);
        this.pad_finger_2 = new ModelRenderer(this, 32, 7).setTextureSize(64, 64);
        this.pad_finger_2.addBox(-1F, -8.5F, -2F, 2, 2, 1, 0.0F);
        this.pad_finger_2.setRotationPoint(0F, posY - 4.0F, 0F);
        this.nail_2 = new ModelRenderer(this, 32, 18).setTextureSize(64, 64);
        this.nail_2.addBox(-0.5F, -10F, -1F, 1, 1, 1, 0.0F);
        this.nail_2.setRotationPoint(0F, posY - 4.0F, 0F);
    }

    private void initFinger3(float posY) {
        this.finger_0_3 = new ModelRenderer(this, 20, 24).setTextureSize(64, 64);
        this.finger_0_3.addBox(-1.5F, -5F, -1F, 3, 5, 2, 0.0F);
        this.finger_0_3.setRotationPoint(0F, posY - 4.0F, 0F);
        this.finger_1_3 = new ModelRenderer(this, 20, 0).setTextureSize(64, 64);
        this.finger_1_3.addBox(-1.5F, -8F, -1.6F, 3, 3, 3, 0.0F);
        this.finger_1_3.setRotationPoint(0F, posY - 4.0F, 0F);
        this.pad_finger_3 = new ModelRenderer(this, 32, 4).setTextureSize(64, 64);
        this.pad_finger_3.addBox(-1F, -7.5F, -2F, 2, 2, 1, 0.0F);
        this.pad_finger_3.setRotationPoint(0F, posY - 4.0F, 0F);
        this.nail_3 = new ModelRenderer(this, 32, 16).setTextureSize(64, 64);
        this.nail_3.addBox(-0.5F, -9F, -1F, 1, 1, 1, 0.0F);
        this.nail_3.setRotationPoint(0F, posY - 4.0F, 0F);
    }

    public void render() {
        this.setRotationAngles();
        this.hilt.render(0.0625F);

        this.hand_0.render(0.0625F);
        this.hand_1.render(0.0625F);
        this.hand_2.render(0.0625F);
        this.hand_3.render(0.0625F);
        this.pad_hand.render(0.0625F);

        this.finger_0_0.render(0.0625F);
        this.finger_1_0.render(0.0625F);
        this.pad_finger_0.render(0.0625F);
        this.nail_0.render(0.0625F);

        this.finger_0_1.render(0.0625F);
        this.finger_1_1.render(0.0625F);
        this.pad_finger_1.render(0.0625F);
        this.nail_1.render(0.0625F);

        this.finger_0_2.render(0.0625F);
        this.finger_1_2.render(0.0625F);
        this.pad_finger_2.render(0.0625F);
        this.nail_2.render(0.0625F);

        this.finger_0_3.render(0.0625F);
        this.finger_1_3.render(0.0625F);
        this.pad_finger_3.render(0.0625F);
        this.nail_3.render(0.0625F);
    }

    public void setRotationAngles() {
        float rotate_0 = 0.7853982F;
        this.finger_0_0.rotateAngleZ = rotate_0;
        this.finger_1_0.rotateAngleZ = rotate_0;
        this.pad_finger_0.rotateAngleZ = rotate_0;
        this.nail_0.rotateAngleZ = rotate_0;

        float rotate_1 = 0.2617994F;
        this.finger_0_1.rotateAngleZ = rotate_1;
        this.finger_1_1.rotateAngleZ = rotate_1;
        this.pad_finger_1.rotateAngleZ = rotate_1;
        this.nail_1.rotateAngleZ = rotate_1;

        float rotate_2 = -0.2617994F;
        this.finger_0_2.rotateAngleZ = rotate_2;
        this.finger_1_2.rotateAngleZ = rotate_2;
        this.pad_finger_2.rotateAngleZ = rotate_2;
        this.nail_2.rotateAngleZ = rotate_2;

        float rotate_3 = -0.7853982F;
        this.finger_0_3.rotateAngleZ = rotate_3;
        this.finger_1_3.rotateAngleZ = rotate_3;
        this.pad_finger_3.rotateAngleZ = rotate_3;
        this.nail_3.rotateAngleZ = rotate_3;
    }
}
