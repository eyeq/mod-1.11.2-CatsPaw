package eyeq.catspaw;

import eyeq.catspaw.client.renderer.tileentity.TileEntitySpecialRendererCatsPaw;
import eyeq.catspaw.item.ItemCatsPaw;
import eyeq.util.client.renderer.ResourceLocationFactory;
import eyeq.util.client.resource.ULanguageCreator;
import eyeq.util.client.resource.lang.LanguageResourceManager;
import eyeq.util.oredict.UOreDictionary;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.io.File;

import static eyeq.catspaw.CatsPaw.MOD_ID;

@Mod(modid = MOD_ID, version = "1.0", dependencies = "after:eyeq_util")
@Mod.EventBusSubscriber
public class CatsPaw {
    public static final String MOD_ID = "eyeq_catspaw";

    @Mod.Instance(MOD_ID)
    public static CatsPaw instance;

    private static final ResourceLocationFactory resource = new ResourceLocationFactory(MOD_ID);

    public static Item catsPaw;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        addRecipes();
        if(event.getSide().isServer()) {
            return;
        }
        renderItemModels();
        createFiles();
    }

    @SubscribeEvent
    protected static void registerItems(RegistryEvent.Register<Item> event) {
        catsPaw = new ItemCatsPaw().setUnlocalizedName("catsPaw");

        GameRegistry.register(catsPaw, resource.createResourceLocation("cats_paw"));
    }

    public static void addRecipes() {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(catsPaw), "FQP", "OWQ", "SOF",
                'P', UOreDictionary.OREDICT_ENDER_PEARL, 'W', new ItemStack(Blocks.WOOL, 1, EnumDyeColor.PINK.getMetadata()), 'S', UOreDictionary.OREDICT_STICK,
                'Q', UOreDictionary.OREDICT_QUARTZ, 'F', Items.FISH, 'O', UOreDictionary.OREDICT_OBSIDIAN));
    }

    @SideOnly(Side.CLIENT)
    public static void renderItemModels() {
        ModelLoader.setCustomMeshDefinition(catsPaw, itemStack -> ResourceLocationFactory.createModelResourceLocation(catsPaw));
        ForgeHooksClient.registerTESRItemStack(catsPaw, 0, TileEntitySpecialRendererCatsPaw.TileEntityCatsPaw.class);
        TileEntityRendererDispatcher.instance.mapSpecialRenderers.put(TileEntitySpecialRendererCatsPaw.TileEntityCatsPaw.class, new TileEntitySpecialRendererCatsPaw());
    }

    public static void createFiles() {
        File project = new File("../1.11.2-CatsPaw");

        LanguageResourceManager language = new LanguageResourceManager();

        language.register(LanguageResourceManager.EN_US, catsPaw, "Cat's Paw");
        language.register(LanguageResourceManager.JA_JP, catsPaw, "にゃんにゃん棒");

        ULanguageCreator.createLanguage(project, MOD_ID, language);
    }
}
