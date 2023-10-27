package com.seailz.discordjar.model.interaction.callback;

import com.seailz.discordjar.DiscordJar;
import com.seailz.discordjar.action.interaction.EditInteractionMessageAction;
import com.seailz.discordjar.action.interaction.followup.InteractionFollowupAction;
import com.seailz.discordjar.model.interaction.callback.internal.InteractionHandlerImpl;
import com.seailz.discordjar.model.message.Message;
import com.seailz.discordjar.utils.rest.DiscordRequest;

/**
 * Class for handling interactions.
 */
public interface InteractionHandler {

    InteractionFollowupAction followup(String content);

    Message getOriginalResponse();
    // TODO: editing

    void deleteOriginalResponse();

    Message getFollowup(String id);

    void deleteFollowup(String id);
    void requirePremium(boolean ephemeral);

    EditInteractionMessageAction editOriginalResponse();

    EditInteractionMessageAction editFollowup(String id);

    void defer(boolean ephemeral);

    default void defer() {
        defer(false);
    }

    /**
     * Only valid for component-based interactions.
     */
    void deferEdit();


    String getToken();

    String getId();

    /**
     * Creates a new InteractionHandler.
     * @param token The token of the interaction.
     * @param id The id of the interaction.
     * @param discordJar The DiscordJar instance.
     * @return The new InteractionHandler.
     */
    static InteractionHandler from(String token, String id, DiscordJar discordJar) {
        return new InteractionHandlerImpl(token, id, discordJar);
    }


}
