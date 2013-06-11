package mc.alk.arena.controllers;

import mc.alk.arena.listeners.PlayerHolder;
import mc.alk.arena.listeners.competition.BlockBreakListener;
import mc.alk.arena.listeners.competition.BlockPlaceListener;
import mc.alk.arena.listeners.competition.ItemDropListener;
import mc.alk.arena.listeners.competition.ItemPickupListener;
import mc.alk.arena.listeners.competition.PlayerTeleportListener;
import mc.alk.arena.listeners.competition.PotionListener;
import mc.alk.arena.objects.MatchTransitions;
import mc.alk.arena.objects.options.TransitionOption;
import mc.alk.arena.objects.scoreboard.ScoreboardFactory;

public class ListenerAdder {

	public static void addListeners(PlayerHolder match, MatchTransitions tops) {
		if (tops.hasAnyOption(TransitionOption.NOTELEPORT, TransitionOption.NOWORLDCHANGE, TransitionOption.WGNOENTER)){
			match.addArenaListener(new PlayerTeleportListener(match));}
		if (tops.hasAnyOption(TransitionOption.BLOCKBREAKON,TransitionOption.BLOCKBREAKOFF)){
			match.addArenaListener(new BlockBreakListener(match));}
		if (tops.hasAnyOption(TransitionOption.BLOCKPLACEON,TransitionOption.BLOCKPLACEOFF)){
			match.addArenaListener(new BlockPlaceListener(match));}
		if (tops.hasAnyOption(TransitionOption.ITEMDROPOFF)){
			match.addArenaListener(new ItemDropListener(match));}
		if (tops.hasAnyOption(TransitionOption.ITEMPICKUPOFF)){
			match.addArenaListener(new ItemPickupListener(match));}
		if (tops.hasAnyOption(TransitionOption.POTIONDAMAGEON)){
			match.addArenaListener(new PotionListener(match));}
		if (!ScoreboardFactory.hasBukkitScoreboard() &&
				TagAPIController.enabled() && !tops.hasAnyOption(TransitionOption.NOTEAMNAMECOLOR)){
			match.addArenaListener(TagAPIController.getNewListener());}
	}

}
