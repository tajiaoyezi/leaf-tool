package org.leaflei.core.tool.convert;

import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.lang.Nullable;
import org.springframework.util.StringValueResolver;

/**
 * @Author leaflei
 * @Date 2023/1/18 18:06
 * @Description 类型 转换 服务，添加了 IEnum 转换
 */

public class LeafConversionService extends ApplicationConversionService {
	@Nullable
	private static volatile LeafConversionService SHARED_INSTANCE;

	public LeafConversionService() {
		this(null);
	}

	public LeafConversionService(@Nullable StringValueResolver embeddedValueResolver) {
		super(embeddedValueResolver);
		super.addConverter(new EnumToStringConverter());
		super.addConverter(new StringToEnumConverter());
	}

	/**
	 * Return a shared default application {@code ConversionService} instance, lazily
	 * building it once needed.
	 * <p>
	 * Note: This method actually returns an {@link LeafConversionService}
	 * instance. However, the {@code ConversionService} signature has been preserved for
	 * binary compatibility.
	 * @return the shared {@code LeafConversionService} instance (never{@code null})
	 */
	public static GenericConversionService getInstance() {
		LeafConversionService sharedInstance = LeafConversionService.SHARED_INSTANCE;
		if (sharedInstance == null) {
			synchronized (LeafConversionService.class) {
				sharedInstance = LeafConversionService.SHARED_INSTANCE;
				if (sharedInstance == null) {
					sharedInstance = new LeafConversionService();
					LeafConversionService.SHARED_INSTANCE = sharedInstance;
				}
			}
		}
		return sharedInstance;
	}

}
