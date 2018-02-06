package com.wallet.crypto.alphawallet.repository;

import com.wallet.crypto.alphawallet.entity.TradeInstance;
import com.wallet.crypto.alphawallet.entity.Wallet;

import java.math.BigDecimal;

import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

public interface WalletRepositoryType {
	Single<Wallet[]> fetchWallets();
	Single<Wallet> findWallet(String address);

	Single<Wallet> createWallet(String password);
	Single<Wallet> importKeystoreToWallet(String store, String password, String newPassword);
    Single<Wallet> importPrivateKeyToWallet(String privateKey, String newPassword);
	Single<String> exportWallet(Wallet wallet, String password, String newPassword);

	Completable deleteWallet(String address, String password);

	Completable setDefaultWallet(Wallet wallet);
	Single<Wallet> getDefaultWallet();

	Single<BigDecimal> balanceInWei(Wallet wallet);
}
