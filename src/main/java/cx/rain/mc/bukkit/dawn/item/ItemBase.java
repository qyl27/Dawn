package cx.rain.mc.bukkit.dawn.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemBase {
    private Material material = null;
    private String name = null;
    private List<String> tooltips = new ArrayList<>();

    public ItemBase(Material materialIn, String nameIn) {
        material = materialIn;
        name = nameIn;
    }

    public ItemBase addTooltips(String... tooltipsIn) {
        tooltips.addAll(Arrays.asList(tooltipsIn));
        return this;
    }

    public ItemStack get(int count) {
        ItemStack item = new ItemStack(material, count);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(tooltips);
        item.setItemMeta(meta);
        item.setAmount(count);
        return item;
    }
}
