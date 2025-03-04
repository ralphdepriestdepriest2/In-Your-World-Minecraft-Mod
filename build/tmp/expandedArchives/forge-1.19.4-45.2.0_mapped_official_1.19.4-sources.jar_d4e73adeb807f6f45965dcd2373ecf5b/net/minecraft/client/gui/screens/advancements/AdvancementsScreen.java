package net.minecraft.client.gui.screens.advancements;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Map;
import javax.annotation.Nullable;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.GameNarrator;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.multiplayer.ClientAdvancements;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ServerboundSeenAdvancementsPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AdvancementsScreen extends Screen implements ClientAdvancements.Listener {
   private static final ResourceLocation WINDOW_LOCATION = new ResourceLocation("textures/gui/advancements/window.png");
   private static final ResourceLocation TABS_LOCATION = new ResourceLocation("textures/gui/advancements/tabs.png");
   public static final int WINDOW_WIDTH = 252;
   public static final int WINDOW_HEIGHT = 140;
   private static final int WINDOW_INSIDE_X = 9;
   private static final int WINDOW_INSIDE_Y = 18;
   public static final int WINDOW_INSIDE_WIDTH = 234;
   public static final int WINDOW_INSIDE_HEIGHT = 113;
   private static final int WINDOW_TITLE_X = 8;
   private static final int WINDOW_TITLE_Y = 6;
   public static final int BACKGROUND_TILE_WIDTH = 16;
   public static final int BACKGROUND_TILE_HEIGHT = 16;
   public static final int BACKGROUND_TILE_COUNT_X = 14;
   public static final int BACKGROUND_TILE_COUNT_Y = 7;
   private static final Component VERY_SAD_LABEL = Component.translatable("advancements.sad_label");
   private static final Component NO_ADVANCEMENTS_LABEL = Component.translatable("advancements.empty");
   private static final Component TITLE = Component.translatable("gui.advancements");
   private final ClientAdvancements advancements;
   private final Map<Advancement, AdvancementTab> tabs = Maps.newLinkedHashMap();
   @Nullable
   private AdvancementTab selectedTab;
   private boolean isScrolling;
   private static int tabPage, maxPages;

   public AdvancementsScreen(ClientAdvancements p_97340_) {
      super(GameNarrator.NO_TITLE);
      this.advancements = p_97340_;
   }

   protected void init() {
      this.tabs.clear();
      this.selectedTab = null;
      this.advancements.setListener(this);
      if (this.selectedTab == null && !this.tabs.isEmpty()) {
         this.advancements.setSelectedTab(this.tabs.values().iterator().next().getAdvancement(), true);
      } else {
         this.advancements.setSelectedTab(this.selectedTab == null ? null : this.selectedTab.getAdvancement(), true);
      }
      if (this.tabs.size() > AdvancementTabType.MAX_TABS) {
          int guiLeft = (this.width - 252) / 2;
          int guiTop = (this.height - 140) / 2;
          addRenderableWidget(net.minecraft.client.gui.components.Button.builder(Component.literal("<"), b -> tabPage = Math.max(tabPage - 1, 0       ))
              .pos(guiLeft, guiTop - 50).size(20, 20).build());
          addRenderableWidget(net.minecraft.client.gui.components.Button.builder(Component.literal(">"), b -> tabPage = Math.min(tabPage + 1, maxPages))
              .pos(guiLeft + WINDOW_WIDTH - 20, guiTop - 50).size(20, 20).build());
          maxPages = this.tabs.size() / AdvancementTabType.MAX_TABS;
      }
   }

   public void removed() {
      this.advancements.setListener((ClientAdvancements.Listener)null);
      ClientPacketListener clientpacketlistener = this.minecraft.getConnection();
      if (clientpacketlistener != null) {
         clientpacketlistener.send(ServerboundSeenAdvancementsPacket.closedScreen());
      }

   }

   public boolean mouseClicked(double p_97343_, double p_97344_, int p_97345_) {
      if (p_97345_ == 0) {
         int i = (this.width - 252) / 2;
         int j = (this.height - 140) / 2;

         for(AdvancementTab advancementtab : this.tabs.values()) {
            if (advancementtab.getPage() == tabPage && advancementtab.isMouseOver(i, j, p_97343_, p_97344_)) {
               this.advancements.setSelectedTab(advancementtab.getAdvancement(), true);
               break;
            }
         }
      }

      return super.mouseClicked(p_97343_, p_97344_, p_97345_);
   }

   public boolean keyPressed(int p_97353_, int p_97354_, int p_97355_) {
      if (this.minecraft.options.keyAdvancements.matches(p_97353_, p_97354_)) {
         this.minecraft.setScreen((Screen)null);
         this.minecraft.mouseHandler.grabMouse();
         return true;
      } else {
         return super.keyPressed(p_97353_, p_97354_, p_97355_);
      }
   }

   public void render(PoseStack p_97361_, int p_97362_, int p_97363_, float p_97364_) {
      int i = (this.width - 252) / 2;
      int j = (this.height - 140) / 2;
      this.renderBackground(p_97361_);
      if (maxPages != 0) {
         net.minecraft.network.chat.Component page = Component.literal(String.format("%d / %d", tabPage + 1, maxPages + 1));
         int width = this.font.width(page);
         this.font.drawShadow(p_97361_, page.getVisualOrderText(), i + (252 / 2) - (width / 2), j - 44, -1);
      }
      this.renderInside(p_97361_, p_97362_, p_97363_, i, j);
      this.renderWindow(p_97361_, i, j);
      this.renderTooltips(p_97361_, p_97362_, p_97363_, i, j);
      super.render(p_97361_, p_97362_, p_97363_, p_97364_);
   }

   public boolean mouseDragged(double p_97347_, double p_97348_, int p_97349_, double p_97350_, double p_97351_) {
      if (p_97349_ != 0) {
         this.isScrolling = false;
         return false;
      } else {
         if (!this.isScrolling) {
            this.isScrolling = true;
         } else if (this.selectedTab != null) {
            this.selectedTab.scroll(p_97350_, p_97351_);
         }

         return true;
      }
   }

   private void renderInside(PoseStack p_97374_, int p_97375_, int p_97376_, int p_97377_, int p_97378_) {
      AdvancementTab advancementtab = this.selectedTab;
      if (advancementtab == null) {
         fill(p_97374_, p_97377_ + 9, p_97378_ + 18, p_97377_ + 9 + 234, p_97378_ + 18 + 113, -16777216);
         int i = p_97377_ + 9 + 117;
         drawCenteredString(p_97374_, this.font, NO_ADVANCEMENTS_LABEL, i, p_97378_ + 18 + 56 - 9 / 2, -1);
         drawCenteredString(p_97374_, this.font, VERY_SAD_LABEL, i, p_97378_ + 18 + 113 - 9, -1);
      } else {
         advancementtab.drawContents(p_97374_, p_97377_ + 9, p_97378_ + 18);
      }
   }

   public void renderWindow(PoseStack p_97357_, int p_97358_, int p_97359_) {
      RenderSystem.enableBlend();
      RenderSystem.setShaderTexture(0, WINDOW_LOCATION);
      blit(p_97357_, p_97358_, p_97359_, 0, 0, 252, 140);
      if (this.tabs.size() > 1) {
         RenderSystem.setShaderTexture(0, TABS_LOCATION);

         for(AdvancementTab advancementtab : this.tabs.values()) {
            if (advancementtab.getPage() == tabPage)
            advancementtab.drawTab(p_97357_, p_97358_, p_97359_, advancementtab == this.selectedTab);
         }

         for(AdvancementTab advancementtab1 : this.tabs.values()) {
            if (advancementtab1.getPage() == tabPage)
            advancementtab1.drawIcon(p_97357_, p_97358_, p_97359_, this.itemRenderer);
         }
      }

      this.font.draw(p_97357_, TITLE, (float)(p_97358_ + 8), (float)(p_97359_ + 6), 4210752);
   }

   private void renderTooltips(PoseStack p_97382_, int p_97383_, int p_97384_, int p_97385_, int p_97386_) {
      if (this.selectedTab != null) {
         p_97382_.pushPose();
         p_97382_.translate((float)(p_97385_ + 9), (float)(p_97386_ + 18), 400.0F);
         RenderSystem.enableDepthTest();
         this.selectedTab.drawTooltips(p_97382_, p_97383_ - p_97385_ - 9, p_97384_ - p_97386_ - 18, p_97385_, p_97386_);
         RenderSystem.disableDepthTest();
         p_97382_.popPose();
      }

      if (this.tabs.size() > 1) {
         for(AdvancementTab advancementtab : this.tabs.values()) {
            if (advancementtab.getPage() == tabPage && advancementtab.isMouseOver(p_97385_, p_97386_, (double)p_97383_, (double)p_97384_)) {
               this.renderTooltip(p_97382_, advancementtab.getTitle(), p_97383_, p_97384_);
            }
         }
      }

   }

   public void onAddAdvancementRoot(Advancement p_97366_) {
      AdvancementTab advancementtab = AdvancementTab.create(this.minecraft, this, this.tabs.size(), p_97366_);
      if (advancementtab != null) {
         this.tabs.put(p_97366_, advancementtab);
      }
   }

   public void onRemoveAdvancementRoot(Advancement p_97372_) {
   }

   public void onAddAdvancementTask(Advancement p_97380_) {
      AdvancementTab advancementtab = this.getTab(p_97380_);
      if (advancementtab != null) {
         advancementtab.addAdvancement(p_97380_);
      }

   }

   public void onRemoveAdvancementTask(Advancement p_97388_) {
   }

   public void onUpdateAdvancementProgress(Advancement p_97368_, AdvancementProgress p_97369_) {
      AdvancementWidget advancementwidget = this.getAdvancementWidget(p_97368_);
      if (advancementwidget != null) {
         advancementwidget.setProgress(p_97369_);
      }

   }

   public void onSelectedTabChanged(@Nullable Advancement p_97391_) {
      this.selectedTab = this.tabs.get(p_97391_);
   }

   public void onAdvancementsCleared() {
      this.tabs.clear();
      this.selectedTab = null;
   }

   @Nullable
   public AdvancementWidget getAdvancementWidget(Advancement p_97393_) {
      AdvancementTab advancementtab = this.getTab(p_97393_);
      return advancementtab == null ? null : advancementtab.getWidget(p_97393_);
   }

   @Nullable
   private AdvancementTab getTab(Advancement p_97395_) {
      while(p_97395_.getParent() != null) {
         p_97395_ = p_97395_.getParent();
      }

      return this.tabs.get(p_97395_);
   }
}
