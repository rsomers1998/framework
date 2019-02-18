package io.ejat.framework.spi;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * <p>Used by the eJAT Framework to initialise the various Configuration Property Stores that may exist within the OSGi instance.  Only 1 CPS maybe enabled during the lifetime of 
 * a eJAT test run or server instance.</p>
 * 
 * <p>The CPS should request from the framework the URI that is defined in the bootstrap.  It should examine the returned URI to 
 * determine if it is this CPS that is required to be initialised.  If the CPS should be initialised, the CPS should do so 
 * and then register itself in the Framework.
 *  
 * @author Michael Baylis
 *
 */
public interface IConfigurationPropertyStoreService {
	
	/**
	 * <p>This method is called to selectively initialise the CPS.  If this CPS is to be initialise, 
	 * it should register the CPS with @{link {@link io.ejat.framework.spi.IFrameworkInitialisation#registerConfigurationPropertyStore(IConfigurationPropertyStore)}</p> 
	 * 
	 * <p>If there is any problem initialising the sole CPS, then an exception will be thrown that will effectively terminate the Framework</p>
	 * 
	 * @param frameworkInitialisation - Initialisation object containing access to various initialisation methods
	 * @throws ConfigurationPropertyStoreException - If there is a problem initialising the underlying store
	 */
	@Null
	void initialise(@NotNull IFrameworkInitialisation frameworkInitialisation) throws ConfigurationPropertyStoreException;

	/**
	 * <p>Retrieve the property from the underlying configuration property store.</p>
	 * 
	 * <p>The framework will prefix with the appropriate namespace and apply the infixes before calling this method</p>
	 * 
	 * @param key - The key of the property to retrieve
	 * @return - The value of the property, or null if it does not exist
	 * @throws ConfigurationPropertyStoreException - If there is a problem accessing the underlying store
	 */
	@Null
	String  getProperty(@NotNull String key) throws ConfigurationPropertyStoreException;
}
