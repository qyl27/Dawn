package cx.rain.mc.bukkit.dawn.crafting;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public abstract class CraftingBase {
    private JavaPlugin plugin = null;

    private final List<ShapedRecipe> ShapedRecipeToAdd = new ArrayList<>();
    private final List<ShapelessRecipe> ShapelessRecipeToAdd = new ArrayList<>();
    private final List<FurnaceRecipe> FurnaceRecipeToAdd = new ArrayList<>();
    private final List<SmokingRecipe> SmokingRecipeToAdd = new ArrayList<>();
    private final List<BlastingRecipe> BlastingRecipeToAdd = new ArrayList<>();
    private final List<CampfireRecipe> CampfireRecipeToAdd = new ArrayList<>();

    private final List<NamespacedKey> ShapedRecipeToRemove = new ArrayList<>();
    private final List<NamespacedKey> ShapelessRecipeToRemove = new ArrayList<>();
    private final List<NamespacedKey> FurnaceRecipeToRemove = new ArrayList<>();
    private final List<NamespacedKey> SmokingRecipeToRemove = new ArrayList<>();
    private final List<NamespacedKey> BlastingRecipeToRemove = new ArrayList<>();
    private final List<NamespacedKey> CampfireRecipeToRemove = new ArrayList<>();

    public CraftingBase(JavaPlugin pluginIn) {
        plugin = pluginIn;

        removeCraftings();
        addCraftings();

        doRemove();
        doAdd();
    }

    private void doAdd() {
        for (ShapedRecipe r : ShapedRecipeToAdd) {
            Bukkit.getServer().addRecipe(r);
        }
        for (ShapelessRecipe r : ShapelessRecipeToAdd) {
            Bukkit.getServer().addRecipe(r);
        }

        for (FurnaceRecipe r : FurnaceRecipeToAdd) {
            Bukkit.getServer().addRecipe(r);
        }
        for (SmokingRecipe r : SmokingRecipeToAdd) {
            Bukkit.getServer().addRecipe(r);
        }
        for (BlastingRecipe r : BlastingRecipeToAdd) {
            Bukkit.getServer().addRecipe(r);
        }
        for (CampfireRecipe r : CampfireRecipeToAdd) {
            Bukkit.getServer().addRecipe(r);
        }
    }

    private void doRemove() {
        for (NamespacedKey k : ShapedRecipeToRemove) {
            Bukkit.removeRecipe(k);
        }
        for (NamespacedKey k : ShapelessRecipeToRemove) {
            Bukkit.removeRecipe(k);
        }

        for (NamespacedKey k : FurnaceRecipeToRemove) {
            Bukkit.removeRecipe(k);
        }
        for (NamespacedKey k : SmokingRecipeToRemove) {
            Bukkit.removeRecipe(k);
        }
        for (NamespacedKey k : BlastingRecipeToRemove) {
            Bukkit.removeRecipe(k);
        }
        for (NamespacedKey k : CampfireRecipeToRemove) {
            Bukkit.removeRecipe(k);
        }
    }

    public NamespacedKey getKey(String name) {
        return new NamespacedKey(plugin, name);
    }
    
    public void addShapedRecipe(ShapedRecipe recipe) {
        ShapedRecipeToAdd.add(recipe);
    }
    public void addShapelessRecipe(ShapelessRecipe recipe) {
        ShapelessRecipeToAdd.add(recipe);
    }
    public void addFurnaceRecipe(FurnaceRecipe recipe) {
        FurnaceRecipeToAdd.add(recipe);
    }
    public void addSmokingRecipe(SmokingRecipe recipe) {
        SmokingRecipeToAdd.add(recipe);
    }
    public void addBlastingRecipe(BlastingRecipe recipe) {
        BlastingRecipeToAdd.add(recipe);
    }
    public void addCampfireRecipe(CampfireRecipe recipe) {
        CampfireRecipeToAdd.add(recipe);
    }

    /**
     * Remove a recipe by name.
     * @param list List of recipe to remove. Should use Craftings#getXXXRecipesToRemove().
     * @param key The name of recipe.
     */
    public void removeRecipeByKey(List<NamespacedKey> list, NamespacedKey key) {
        list.add(key);
    }

    /**
     * Remove all the recipes of Item.
     * @param item Item to remove recipes.
     */
    public void removeRecipeByItem(ItemStack item) {
        List<Recipe> recipes = Bukkit.getRecipesFor(item);
        for (Recipe r : recipes) {
            if (recipes instanceof ShapedRecipe) {
                ShapedRecipeToRemove.add(((ShapedRecipe) recipes).getKey());
            } else if (recipes instanceof ShapelessRecipe) {
                ShapelessRecipeToRemove.add(((ShapelessRecipe) recipes).getKey());
            } else if (recipes instanceof FurnaceRecipe) {
                FurnaceRecipeToRemove.add(((FurnaceRecipe) recipes).getKey());
            } else if (recipes instanceof SmokingRecipe) {
                SmokingRecipeToRemove.add(((SmokingRecipe) recipes).getKey());
            } else if (recipes instanceof BlastingRecipe) {
                BlastingRecipeToRemove.add(((BlastingRecipe) recipes).getKey());
            } else if (recipes instanceof CampfireRecipe) {
                CampfireRecipeToRemove.add(((CampfireRecipe) recipes).getKey());
            }
        }
    }

    public abstract void addCraftings();

    public abstract void removeCraftings();

    public List<ShapedRecipe> getShapedRecipeToAdd() {
        return ShapedRecipeToAdd;
    }
    public List<ShapelessRecipe> getShapelessRecipeToAdd() {
        return ShapelessRecipeToAdd;
    }

    public List<FurnaceRecipe> getFurnaceRecipeToAdd() {
        return FurnaceRecipeToAdd;
    }
    public List<SmokingRecipe> getSmokingRecipeToAdd() {
        return SmokingRecipeToAdd;
    }
    public List<BlastingRecipe> getBlastingRecipeToAdd() {
        return BlastingRecipeToAdd;
    }
    public List<CampfireRecipe> getCampfireRecipeToAdd() {
        return CampfireRecipeToAdd;
    }

    public List<NamespacedKey> getShapedRecipeToRemove() {
        return ShapedRecipeToRemove;
    }
    public List<NamespacedKey> getShapelessRecipeToRemove() {
        return ShapelessRecipeToRemove;
    }

    public List<NamespacedKey> getFurnaceRecipeToRemove() {
        return FurnaceRecipeToRemove;
    }
    public List<NamespacedKey> getSmokingRecipeToRemove() {
        return SmokingRecipeToRemove;
    }
    public List<NamespacedKey> getBlastingRecipeToRemove() {
        return BlastingRecipeToRemove;
    }
    public List<NamespacedKey> getCampfireRecipeToRemove() {
        return CampfireRecipeToRemove;
    }
}
