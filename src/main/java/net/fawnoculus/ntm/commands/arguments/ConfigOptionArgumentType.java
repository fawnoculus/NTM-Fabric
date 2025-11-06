package net.fawnoculus.ntm.commands.arguments;

import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.fawnoculus.ntm.api.config.ConfigFile;
import net.fawnoculus.ntm.api.config.ConfigOption;
import net.minecraft.command.CommandSource;
import net.minecraft.command.argument.ArgumentReaderUtils;
import net.minecraft.text.Text;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public record ConfigOptionArgumentType(Supplier<ConfigFile> configFile,
									   Supplier<Set<String>> optionNames) implements ArgumentType<ConfigOption<?>> {
	private static final DynamicCommandExceptionType OPTION_NAME_INVALID = new DynamicCommandExceptionType(
	  name -> Text.stringifiedTranslatable("command.ntm.option_argument.name_invalid", name)
	);

	public static ConfigOptionArgumentType file(ConfigFile file) {
		return new ConfigOptionArgumentType(() -> file, file::getOptionsNames);
	}

	public static ConfigOptionArgumentType file(Supplier<ConfigFile> supplier) {
		return new ConfigOptionArgumentType(supplier, () -> supplier.get().getOptionsNames());
	}

	public static ConfigOption<?> getOption(final CommandContext<?> context, final String name) {
		return context.getArgument(name, ConfigOption.class);
	}

	@Override
	public ConfigOption<?> parse(StringReader reader) throws CommandSyntaxException {
		String name = ArgumentReaderUtils.readWhileMatching(reader, c -> c != ' ');
		ConfigOption<?> option = this.configFile.get().getOption(name);
		if (option == null && !this.optionNames.get().contains(name)) {
			throw OPTION_NAME_INVALID.create(name);
		}
		return option;
	}

	@Override
	public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
		return CommandSource.suggestMatching(this.optionNames.get(), builder);
	}

	@Override
	public Collection<String> getExamples() {
		return this.optionNames.get();
	}
}
