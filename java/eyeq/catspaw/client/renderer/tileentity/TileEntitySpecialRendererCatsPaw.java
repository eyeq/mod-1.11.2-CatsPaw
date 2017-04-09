package eyeq.catspaw.client.renderer.tileentity;

import eyeq.catspaw.client.model.ModelCatsPaw;
import eyeq.util.client.renderer.EntityRenderResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static eyeq.catspaw.CatsPaw.MOD_ID;

@SideOnly(Side.CLIENT)
public class TileEntitySpecialRendererCatsPaw extends TileEntitySpecialRenderer<TileEntitySpecialRendererCatsPaw.TileEntityCatsPaw> {
    protected static final ResourceLocation textures = new EntityRenderResourceLocation(MOD_ID, "cats_paw");

    protected final ModelCatsPaw baseModel = new ModelCatsPaw();

    @Override
    public void renderTileEntityAt(TileEntityCatsPaw te, double x, double y, double z, float partialTicks, int destroyStage) {
        Minecraft.getMinecraft().getTextureManager().bindTexture(textures);
        GlStateManager.pushMatrix();
        GlStateManager.scale(1.0F, -1.0F, -1.0F);
        this.baseModel.render();
        GlStateManager.popMatrix();
    }

    @SideOnly(Side.CLIENT)
    public class TileEntityCatsPaw extends TileEntity {
    }
}
